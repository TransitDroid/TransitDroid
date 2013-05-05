var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":19,"id":3270,"methods":[{"el":17,"sc":2,"sl":11}],"name":"YearlyTest","sl":9}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1440":{"methods":[{"sl":11}],"name":"test","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":15},{"sl":16}]},"test_785":{"methods":[{"sl":11}],"name":"test","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":15},{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [1440, 785], [], [1440, 785], [1440, 785], [1440, 785], [1440, 785], [], [], []]
