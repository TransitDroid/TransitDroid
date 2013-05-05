var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":19,"id":1016,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14}],"name":"MonthyPassTIGTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":14}],"name":"testFind","pass":false,"statements":[{"sl":16}]},"test_123":{"methods":[{"sl":9}],"name":"testFindAll","pass":false,"statements":[{"sl":11}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [123], [], [123], [], [], [1], [], [1], [], [], []]
