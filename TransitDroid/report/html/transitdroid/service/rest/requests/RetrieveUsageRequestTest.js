var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":14,"id":2542,"methods":[{"el":12,"sc":2,"sl":9}],"name":"RetrieveUsageRequestTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_631":{"methods":[{"sl":9}],"name":"test","pass":false,"statements":[{"sl":11}]},"test_746":{"methods":[{"sl":9}],"name":"test","pass":false,"statements":[{"sl":11}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [631, 746], [], [631, 746], [], [], []]
