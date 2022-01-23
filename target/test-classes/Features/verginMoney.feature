Feature: Verify the customer view balance on mobile
  Scenario:1.Customer able to download app on android
    Given customer on google play page
    When cusomer download the mobile app on his mobile
    Then customer can see his app icon on mobile screen
   Scenario: 2.Customer able to download app on ios
     Given customer on download on app store
     When cusomer download the mobile app on his mobile
     Then customer can see his app icon  on mobile screen
   Scenario: 3.Customer able to register his mobile for login his account
     Given customer on app page
     When customer open app first time customer need to enter the valid detail about account and mobile number
     Then customer view on his account page
   Scenario: 4.customer able to view his balance on screen without login only registered mobile only
     Given customer is on app page
     When customer is click on fast balance buttton on app home page
     Then customer view his balance on screen
     Scenario: 5.Customer are not able to view balance on other mobile which is not registered



