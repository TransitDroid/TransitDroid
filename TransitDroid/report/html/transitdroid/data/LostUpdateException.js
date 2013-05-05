var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":12,"id":2183,"methods":[{"el":10,"sc":2,"sl":8}],"name":"LostUpdateException","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_358":{"methods":[{"sl":8}],"name":"testUpdateCard","pass":false,"statements":[{"sl":9}]},"test_470":{"methods":[{"sl":8}],"name":"testUpdateCard","pass":false,"statements":[{"sl":9}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [470, 358], [470, 358], [], [], []]
