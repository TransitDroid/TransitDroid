var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":24,"id":969,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19}],"name":"MobileDeviceTIGTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_12":{"methods":[{"sl":9}],"name":"testFindAll","pass":false,"statements":[{"sl":11}]},"test_168":{"methods":[{"sl":14}],"name":"testFindUUID","pass":false,"statements":[{"sl":16}]},"test_72":{"methods":[{"sl":19}],"name":"testFindString","pass":false,"statements":[{"sl":21}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [12], [], [12], [], [], [168], [], [168], [], [], [72], [], [72], [], [], []]
