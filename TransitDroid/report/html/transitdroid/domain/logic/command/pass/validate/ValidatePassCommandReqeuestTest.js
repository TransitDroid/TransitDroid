var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":19,"id":2860,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14}],"name":"ValidatePassCommandReqeuestTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1113":{"methods":[{"sl":14}],"name":"testSetCard","pass":false,"statements":[{"sl":16}]},"test_1257":{"methods":[{"sl":9}],"name":"testGetCard","pass":false,"statements":[{"sl":11}]},"test_1282":{"methods":[{"sl":9}],"name":"testGetCard","pass":false,"statements":[{"sl":11}]},"test_1340":{"methods":[{"sl":14}],"name":"testSetCard","pass":false,"statements":[{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [1257, 1282], [], [1257, 1282], [], [], [1113, 1340], [], [1113, 1340], [], [], []]
