package com.yummyyum.Services.Subscription.Impl;

import com.yummyyum.Model.*;
import com.yummyyum.Model.DTO.SubscriptionDTO;
import com.yummyyum.Model.EmbeddedIDs.UserSubscriptionPaymentId;
import com.yummyyum.Model.TernaryRelationships.UserSubscriptionPaymentRelationship.UserSubscriptionPayment;
import com.yummyyum.Repositories.*;
import com.yummyyum.Services.Subscription.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionPlanRepository subscriptionPlanRepository;
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;
    private final DeliveryAddressRepository deliveryAddressRepository;
    private final UserSubscriptionPaymentRepository userSubscriptionPaymentRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository,
                                   SubscriptionPlanRepository subscriptionPlanRepository,
                                   UserRepository userRepository, PaymentRepository paymentRepository,
                                   DeliveryAddressRepository deliveryAddressRepository,
                                   UserSubscriptionPaymentRepository userSubscriptionPaymentRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionPlanRepository = subscriptionPlanRepository;
        this.userRepository = userRepository;
        this.paymentRepository = paymentRepository;
        this.deliveryAddressRepository = deliveryAddressRepository;
        this.userSubscriptionPaymentRepository = userSubscriptionPaymentRepository;
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @Override
    public SubscriptionDTO getSubscriptionBySubscriptionPlanName(String subscriptionPlanName) {
        Optional<Subscription> subscription =
                subscriptionRepository.getSubscriptionBySubscriptionPlanName(subscriptionPlanName);
        Optional<SubscriptionPlan> subscriptionPlan =
                subscriptionPlanRepository.getSubscriptionPlanByName(subscriptionPlanName);

        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        subscriptionDTO.setName(subscriptionPlan.get().getName());
        subscriptionDTO.setIsActive(subscriptionPlan.get().getIsActive());
        subscriptionDTO.setNumberOfWeeklyMeals(subscription.get().getNumberOfWeeklyMeals());
        subscriptionDTO.setServingsPerMeal(subscription.get().getServingsPerMeal());
        subscriptionDTO.setSubscriptionType(subscription.get().getSubscriptionType());
        subscriptionDTO.setWeeklyDeliveryDay(subscription.get().getWeeklyDeliveryDay());
        subscriptionDTO.setWeeklyDeliveryTime(subscription.get().getWeeklyDeliveryTime());
        subscriptionDTO.setActivationDate(subscription.get().getActivationDate());
        subscriptionDTO.setCanceledDate(subscription.get().getCanceledDate());

        return subscriptionDTO;
    }

    @Override
    public Long getSubscriptionIdBySubscriptionPlanName(String subscriptionPlanName) {
        return subscriptionRepository.getSubscriptionIdBySubscriptionPlanName(subscriptionPlanName);
    }

    @Override
    public List<Subscription> getAllSubscriptionsByIsCanceled(Boolean isCanceled) {
        return subscriptionRepository.getAllSubscriptionsByIsCanceled(isCanceled);
    }

    @Override
    public List<Subscription> getAllSubscriptionsByActivationDate(LocalDate activationDate) {
        return subscriptionRepository.getAllSubscriptionsByActivationDate(activationDate);
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCanceledDate(LocalDate canceledDate) {
        return subscriptionRepository.getAllSubscriptionsByCanceledDate(canceledDate);
    }

    @Override
    public SubscriptionDTO getSubscriptionByUsername(String username) {
        Optional<Subscription> subscription = subscriptionRepository.getSubscriptionByUsername(username);

        return new SubscriptionDTO(subscription.get().getSubscriptionPlan().getName(), !subscription.get().getIsCanceled(), subscription.get().getNumberOfWeeklyMeals(),
                subscription.get().getServingsPerMeal(), subscription.get().getSubscriptionType(), subscription.get().getWeeklyDeliveryDay(),
                subscription.get().getWeeklyDeliveryTime(), subscription.get().getIsCanceled(),
                subscription.get().getActivationDate(), subscription.get().getCanceledDate());
    }

    @Override
    public Subscription createNewSubscription(SubscriptionDTO subscriptionDTO, String subscriptionPlanName,
                                              String username, String cardNumber, Float totalAmount,
                                              String address, String zipCode) {

        Optional<Subscription> oldSubscription = subscriptionRepository.getSubscriptionByUsername(username);
        Subscription newSubscription = null;

        if (!oldSubscription.isPresent()) {
            newSubscription = new Subscription(
                    subscriptionDTO.getNumberOfWeeklyMeals(),
                    subscriptionDTO.getServingsPerMeal(),
                    subscriptionDTO.getSubscriptionType(),
                    subscriptionDTO.getWeeklyDeliveryDay(),
                    subscriptionDTO.getWeeklyDeliveryTime(),
                    subscriptionDTO.getIsCanceled(),
                    subscriptionDTO.getActivationDate(),
                    subscriptionDTO.getCanceledDate());
        } else {
            newSubscription = new Subscription(
                    subscriptionDTO.getNumberOfWeeklyMeals(),
                    subscriptionDTO.getServingsPerMeal(),
                    subscriptionDTO.getSubscriptionType(),
                    subscriptionDTO.getWeeklyDeliveryDay(),
                    subscriptionDTO.getWeeklyDeliveryTime(),
                    subscriptionDTO.getIsCanceled(),
                    subscriptionDTO.getActivationDate(),
                    subscriptionDTO.getCanceledDate());
            newSubscription.setId(oldSubscription.get().getId());
        }


        Optional<SubscriptionPlan> subscriptionPlan =
                subscriptionPlanRepository.getSubscriptionPlanByName(subscriptionDTO.getName());
        newSubscription.setSubscriptionPlan(subscriptionPlan.get());
        subscriptionRepository.save(newSubscription);

        String paymentID;
        boolean isExist = false;
        LocalDateTime newDate = LocalDateTime.now();

        Random rnd = new Random();
        int number = rnd.nextInt(999999);
//        // this will convert any number sequence into 6 character.
        String code = String.format("%06d", number);

        String stringTest1 = String.valueOf(newDate.getYear());
        String stringTest2 = String.valueOf(newDate.getMonthValue());
        String stringTest3 = String.valueOf(newDate.getDayOfMonth());

        paymentID = stringTest1 + stringTest2 + stringTest3 + code;

        Optional<Payment> paymentValues = paymentRepository.getPaymentByPaymentNumberID(paymentID);
        if (!paymentValues.isEmpty()) {
            isExist = true;
        }

        while (isExist) {
            number = rnd.nextInt(999999);
            code = String.format("%06d", number);
            paymentID = stringTest1 + stringTest2 + stringTest3 + code;
            Optional<Payment> paymentValues2 = paymentRepository.getPaymentByPaymentNumberID(paymentID);
            if (paymentValues2.isEmpty()) {
                isExist = false;
            }
        }
        Payment payment = new Payment(paymentID, cardNumber, new Date(), totalAmount);
        paymentRepository.save(payment);
        Optional<Payment> getPayment = paymentRepository.getPaymentByPaymentNumberID(paymentID);

        DeliveryAddress deliveryAddress = new DeliveryAddress(address, zipCode);
        deliveryAddress.setPayment(getPayment.get());
        deliveryAddressRepository.save(deliveryAddress);


        Optional<User> user = userRepository.getUserByUsername(username);
        Optional<Subscription> subscriptionObj =
                subscriptionRepository.getSubscriptionBySubscriptionPlanName(subscriptionDTO.getName());
        UserSubscriptionPaymentId userSubscriptionPaymentId = new UserSubscriptionPaymentId(user.get().getId(),
                subscriptionObj.get().getId(), getPayment.get().getId());

        UserSubscriptionPayment userSubscriptionPayment = new UserSubscriptionPayment(userSubscriptionPaymentId);
        userSubscriptionPaymentRepository.save(userSubscriptionPayment);

        return newSubscription;
    }

    @Override
    public Subscription updateSubscription(int numberOfWeeklyMeals, int servingsPerMeal, String subscriptionType,
                                           String weeklyDeliveryDay, String weeklyDeliveryTime, Boolean isCanceled,
                                           LocalDate activationDate, LocalDate canceledDate, String subscriptionPlanName) {

        Optional<Subscription> subscriptionObj =
                subscriptionRepository.getSubscriptionBySubscriptionPlanName(subscriptionPlanName);

        Subscription subscription = new Subscription();

        if (subscriptionObj.isPresent()) {
            SubscriptionObject(numberOfWeeklyMeals, servingsPerMeal, subscriptionType,
                    weeklyDeliveryDay, weeklyDeliveryTime, isCanceled,
                    activationDate, canceledDate, subscription);
            Long id = subscriptionRepository.getSubscriptionIdBySubscriptionPlanName(subscriptionPlanName);
            subscription.setId(id);
        } else {
            SubscriptionObject(numberOfWeeklyMeals, servingsPerMeal, subscriptionType,
                    weeklyDeliveryDay, weeklyDeliveryTime, isCanceled,
                    activationDate, canceledDate, subscription);
        }

        Optional<SubscriptionPlan> subscriptionPlan =
                subscriptionPlanRepository.getSubscriptionPlanByName(subscriptionPlanName);
        subscription.setSubscriptionPlan(subscriptionPlan.get());

        return subscriptionRepository.saveAndFlush(subscription);
    }

    private void SubscriptionObject(int numberOfWeeklyMeals, int servingsPerMeal,
                                    String subscriptionType, String weeklyDeliveryDay,
                                    String weeklyDeliveryTime, Boolean isCanceled, LocalDate activationDate,
                                    LocalDate canceledDate, Subscription subscription) {
        subscription.setNumberOfWeeklyMeals(numberOfWeeklyMeals);
        subscription.setServingsPerMeal(servingsPerMeal);
        subscription.setSubscriptionType(subscriptionType);
        subscription.setWeeklyDeliveryDay(weeklyDeliveryDay);
        subscription.setWeeklyDeliveryTime(weeklyDeliveryTime);
        subscription.setIsCanceled(isCanceled);
        subscription.setActivationDate(activationDate);
        subscription.setCanceledDate(canceledDate);
    }

}
