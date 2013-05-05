var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":24,"id":3467,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19}],"name":"NightlyPassIdentityMapTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1223":{"methods":[{"sl":14}],"name":"testGet","pass":false,"statements":[{"sl":16}]},"test_1545":{"methods":[{"sl":9}],"name":"testGetUniqueInstance","pass":false,"statements":[{"sl":11}]},"test_187":{"methods":[{"sl":19}],"name":"testPut","pass":false,"statements":[{"sl":21}]},"test_792":{"methods":[{"sl":19}],"name":"testPut","pass":false,"statements":[{"sl":21}]},"test_946":{"methods":[{"sl":14}],"name":"testGet","pass":false,"statements":[{"sl":16}]},"test_950":{"methods":[{"sl":9}],"name":"testGetUniqueInstance","pass":false,"statements":[{"sl":11}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [950, 1545], [], [950, 1545], [], [], [1223, 946], [], [1223, 946], [], [], [792, 187], [], [792, 187], [], [], []]
