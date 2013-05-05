var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":29,"id":3435,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19},{"el":27,"sc":2,"sl":24}],"name":"SinglePassFactoryTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1052":{"methods":[{"sl":24}],"name":"testCreateClean","pass":false,"statements":[{"sl":26}]},"test_1126":{"methods":[{"sl":19}],"name":"testCreateNew","pass":false,"statements":[{"sl":21}]},"test_1418":{"methods":[{"sl":19}],"name":"testCreateNew","pass":false,"statements":[{"sl":21}]},"test_1419":{"methods":[{"sl":14}],"name":"testCreateNewUUIDIntIntDoubleDateCheckpoint","pass":false,"statements":[{"sl":16}]},"test_163":{"methods":[{"sl":9}],"name":"testCreateNewIntDoubleDateCheckpoint","pass":false,"statements":[{"sl":11}]},"test_370":{"methods":[{"sl":14}],"name":"testCreateNewUUIDIntIntDoubleDateCheckpoint","pass":false,"statements":[{"sl":16}]},"test_709":{"methods":[{"sl":9}],"name":"testCreateNewIntDoubleDateCheckpoint","pass":false,"statements":[{"sl":11}]},"test_928":{"methods":[{"sl":24}],"name":"testCreateClean","pass":false,"statements":[{"sl":26}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [709, 163], [], [709, 163], [], [], [370, 1419], [], [370, 1419], [], [], [1418, 1126], [], [1418, 1126], [], [], [1052, 928], [], [1052, 928], [], [], []]
