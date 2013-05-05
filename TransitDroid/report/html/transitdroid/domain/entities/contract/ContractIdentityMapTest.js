var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":24,"id":3750,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19}],"name":"ContractIdentityMapTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1512":{"methods":[{"sl":9}],"name":"testGetUniqueInstance","pass":false,"statements":[{"sl":11}]},"test_28":{"methods":[{"sl":14}],"name":"testGet","pass":false,"statements":[{"sl":16}]},"test_293":{"methods":[{"sl":19}],"name":"testPut","pass":false,"statements":[{"sl":21}]},"test_716":{"methods":[{"sl":14}],"name":"testGet","pass":false,"statements":[{"sl":16}]},"test_777":{"methods":[{"sl":19}],"name":"testPut","pass":false,"statements":[{"sl":21}]},"test_947":{"methods":[{"sl":9}],"name":"testGetUniqueInstance","pass":false,"statements":[{"sl":11}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [1512, 947], [], [1512, 947], [], [], [716, 28], [], [716, 28], [], [], [777, 293], [], [777, 293], [], [], []]
