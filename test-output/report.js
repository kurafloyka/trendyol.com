$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/user/IdeaProjects/n11.com/src/main/java/com/qa/features/n11.feature");
formatter.feature({
  "line": 1,
  "name": "n11.com Applications Test",
  "description": "",
  "id": "n11.com-applications-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5675221463,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Validate n11.com Home Page Test",
  "description": "",
  "id": "n11.com-applications-test;validate-n11.com-home-page-test",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "close the main popup",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user is on login page",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user enter username and password",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.closeTheMainPopup()"
});
formatter.result({
  "duration": 10269265065,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_is_on_login_page()"
});
formatter.result({
  "duration": 103706661,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_enters_username_and_password()"
});
formatter.result({
  "duration": 6839720635,
  "status": "passed"
});
formatter.after({
  "duration": 236739858,
  "status": "passed"
});
formatter.before({
  "duration": 5207046248,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Password is wrong",
  "description": "",
  "id": "n11.com-applications-test;password-is-wrong",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "close the main popup",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "user is on login page",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user enter username without password",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.closeTheMainPopup()"
});
formatter.result({
  "duration": 13405153864,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_is_on_login_page()"
});
formatter.result({
  "duration": 86181839,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.userEnterEmailWithoutPassword()"
});
formatter.result({
  "duration": 5984653039,
  "error_message": "java.lang.AssertionError: expected:\u003ctrue\u003e but was:\u003cfalse\u003e\n\tat org.junit.Assert.fail(Assert.java:88)\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\n\tat org.junit.Assert.assertEquals(Assert.java:118)\n\tat org.junit.Assert.assertEquals(Assert.java:144)\n\tat com.qa.stepdefinations.HomePageSteps.userEnterEmailWithoutPassword(HomePageSteps.java:68)\n\tat ✽.Then user enter username without password(/Users/user/IdeaProjects/n11.com/src/main/java/com/qa/features/n11.feature:14)\n",
  "status": "failed"
});
formatter.after({
  "duration": 878683144,
  "status": "passed"
});
formatter.before({
  "duration": 4357726223,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "check AllManButiqueLinks",
  "description": "",
  "id": "n11.com-applications-test;check-allmanbutiquelinks",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "go to man butique",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "check all url",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.goToManButique()"
});
formatter.result({
  "duration": 321490450860,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "duration": 175268556,
  "status": "passed"
});
});