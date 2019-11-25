# qa-test-hf

## Overall informartion

Automation test project to cover the tests cases:

1- *User should be able to Signin*

2- *User should be able to Login*

3- *User should be able to place an order*

#### Classes of test and test methods:

    AuthenticationTest
        signInTest()
        logInTest()

    OrderCheckoutTest
        checkoutTest()


Find steps, validations and expect results in **TESTCASES.md** file.

## Execution and Technical information

This project uses Maven as build platform so the test can be executed using command line:

    mvn clean test

You can set specific browser, test class and url like the example bellow:

    mvn -Dbrowser=chrome -Dtest=OrderCheckoutTest -Durl=http://automationpractice.com/index.php test


Possible values for browser are: `chrome` or `firefox`.

**Note** that by default the browser is `chrome`, url is `http://automationpractice.com/index.php` and all the test classes will be executed.

The code is in Java and JUnit for tests.
