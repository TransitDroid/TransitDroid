var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":24,"id":3419,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19}],"name":"SinglePassOutMapperTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1290":{"methods":[{"sl":19}],"name":"testRemoveSinglePass","pass":false,"statements":[{"sl":21}]},"test_368":{"methods":[{"sl":19}],"name":"testRemoveSinglePass","pass":false,"statements":[{"sl":21}]},"test_471":{"methods":[{"sl":9}],"name":"testInsertSinglePass","pass":false,"statements":[{"sl":11}]},"test_677":{"methods":[{"sl":9}],"name":"testInsertSinglePass","pass":false,"statements":[{"sl":11}]},"test_76":{"methods":[{"sl":14}],"name":"testUpdateSinglePass","pass":false,"statements":[{"sl":16}]},"test_977":{"methods":[{"sl":14}],"name":"testUpdateSinglePass","pass":false,"statements":[{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [471, 677], [], [471, 677], [], [], [977, 76], [], [977, 76], [], [], [1290, 368], [], [1290, 368], [], [], []]
