var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":29,"id":3325,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19},{"el":27,"sc":2,"sl":24}],"name":"YearlyPassFactoryTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1337":{"methods":[{"sl":19}],"name":"testCreateNew","pass":false,"statements":[{"sl":21}]},"test_134":{"methods":[{"sl":14}],"name":"testCreateNewUUIDIntDate","pass":false,"statements":[{"sl":16}]},"test_1578":{"methods":[{"sl":19}],"name":"testCreateNew","pass":false,"statements":[{"sl":21}]},"test_457":{"methods":[{"sl":24}],"name":"testCreateClean","pass":false,"statements":[{"sl":26}]},"test_538":{"methods":[{"sl":9}],"name":"testCreateNewDate","pass":false,"statements":[{"sl":11}]},"test_884":{"methods":[{"sl":24}],"name":"testCreateClean","pass":false,"statements":[{"sl":26}]},"test_934":{"methods":[{"sl":9}],"name":"testCreateNewDate","pass":false,"statements":[{"sl":11}]},"test_970":{"methods":[{"sl":14}],"name":"testCreateNewUUIDIntDate","pass":false,"statements":[{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [934, 538], [], [934, 538], [], [], [970, 134], [], [970, 134], [], [], [1337, 1578], [], [1337, 1578], [], [], [457, 884], [], [457, 884], [], [], []]
