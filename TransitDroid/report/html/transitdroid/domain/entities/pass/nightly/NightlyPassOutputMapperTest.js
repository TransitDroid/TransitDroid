var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":24,"id":3459,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19}],"name":"NightlyPassOutputMapperTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1132":{"methods":[{"sl":19}],"name":"testRemoveNightlyPass","pass":false,"statements":[{"sl":21}]},"test_1345":{"methods":[{"sl":9}],"name":"testInsertNightlyPass","pass":false,"statements":[{"sl":11}]},"test_29":{"methods":[{"sl":14}],"name":"testUpdateNightlyPass","pass":false,"statements":[{"sl":16}]},"test_294":{"methods":[{"sl":19}],"name":"testRemoveNightlyPass","pass":false,"statements":[{"sl":21}]},"test_883":{"methods":[{"sl":9}],"name":"testInsertNightlyPass","pass":false,"statements":[{"sl":11}]},"test_998":{"methods":[{"sl":14}],"name":"testUpdateNightlyPass","pass":false,"statements":[{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [1345, 883], [], [1345, 883], [], [], [998, 29], [], [998, 29], [], [], [294, 1132], [], [294, 1132], [], [], []]
