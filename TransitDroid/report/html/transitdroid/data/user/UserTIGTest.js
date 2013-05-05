var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":29,"id":1080,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19},{"el":27,"sc":2,"sl":24}],"name":"UserTIGTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_134":{"methods":[{"sl":24}],"name":"testGetVersion","pass":false,"statements":[{"sl":26}]},"test_145":{"methods":[{"sl":14}],"name":"testFindUUID","pass":false,"statements":[{"sl":16}]},"test_57":{"methods":[{"sl":9}],"name":"testFindAll","pass":false,"statements":[{"sl":11}]},"test_8":{"methods":[{"sl":19}],"name":"testFindString","pass":false,"statements":[{"sl":21}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [57], [], [57], [], [], [145], [], [145], [], [], [8], [], [8], [], [], [134], [], [134], [], [], []]
