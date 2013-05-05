var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":37,"id":2373,"methods":[{"el":18,"sc":2,"sl":15},{"el":22,"sc":2,"sl":21},{"el":28,"sc":2,"sl":25},{"el":32,"sc":2,"sl":30},{"el":35,"sc":2,"sl":33}],"name":"DailyPass","sl":10}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":15},{"sl":30}],"name":"testGetDate","pass":true,"statements":[{"sl":16},{"sl":17},{"sl":31}]},"test_16":{"methods":[{"sl":15},{"sl":30},{"sl":33}],"name":"testSetDate","pass":true,"statements":[{"sl":16},{"sl":17},{"sl":31},{"sl":34}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [10, 16], [10, 16], [10, 16], [], [], [], [], [], [], [], [], [], [], [], [], [10, 16], [10, 16], [], [16], [16], [], [], []]
