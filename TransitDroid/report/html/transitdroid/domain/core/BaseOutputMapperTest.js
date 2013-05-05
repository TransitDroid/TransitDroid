var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":24,"id":1106,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19}],"name":"BaseOutputMapperTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_120":{"methods":[{"sl":9}],"name":"testInsert","pass":false,"statements":[{"sl":11}]},"test_135":{"methods":[{"sl":14}],"name":"testUpdate","pass":false,"statements":[{"sl":16}]},"test_76":{"methods":[{"sl":19}],"name":"testRemove","pass":false,"statements":[{"sl":21}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [120], [], [120], [], [], [135], [], [135], [], [], [76], [], [76], [], [], []]
