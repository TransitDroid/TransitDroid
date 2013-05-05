var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":23,"id":1160,"methods":[{"el":21,"sc":2,"sl":9}],"name":"GuardTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_64":{"methods":[{"sl":9}],"name":"testNotNull","pass":true,"statements":[{"sl":11},{"sl":12},{"sl":13},{"sl":16},{"sl":18},{"sl":20}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [64], [], [64], [64], [64], [], [], [64], [], [64], [], [64], [], [], []]
