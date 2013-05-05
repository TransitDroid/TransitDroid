var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":29,"id":2999,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19},{"el":27,"sc":2,"sl":24}],"name":"PurchaseSinglePassCommandResponseTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1131":{"methods":[{"sl":14}],"name":"testSetSucceed","pass":false,"statements":[{"sl":16}]},"test_1206":{"methods":[{"sl":24}],"name":"testSetException","pass":false,"statements":[{"sl":26}]},"test_123":{"methods":[{"sl":14}],"name":"testSetSucceed","pass":false,"statements":[{"sl":16}]},"test_1442":{"methods":[{"sl":9}],"name":"testIsSucceed","pass":false,"statements":[{"sl":11}]},"test_1552":{"methods":[{"sl":9}],"name":"testIsSucceed","pass":false,"statements":[{"sl":11}]},"test_816":{"methods":[{"sl":24}],"name":"testSetException","pass":false,"statements":[{"sl":26}]},"test_840":{"methods":[{"sl":19}],"name":"testGetException","pass":false,"statements":[{"sl":21}]},"test_994":{"methods":[{"sl":19}],"name":"testGetException","pass":false,"statements":[{"sl":21}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [1442, 1552], [], [1442, 1552], [], [], [123, 1131], [], [123, 1131], [], [], [994, 840], [], [994, 840], [], [], [1206, 816], [], [1206, 816], [], [], []]
