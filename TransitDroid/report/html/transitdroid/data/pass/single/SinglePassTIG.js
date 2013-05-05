var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":28,"id":1839,"methods":[{"el":13,"sc":2,"sl":10},{"el":20,"sc":2,"sl":16},{"el":26,"sc":2,"sl":22}],"name":"SinglePassTIG","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1399":{"methods":[{"sl":10},{"sl":22}],"name":"testExecute","pass":false,"statements":[{"sl":12},{"sl":23},{"sl":24},{"sl":25}]},"test_648":{"methods":[{"sl":10},{"sl":22}],"name":"testExecute","pass":false,"statements":[{"sl":12},{"sl":23},{"sl":24},{"sl":25}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [1399, 648], [], [1399, 648], [], [], [], [], [], [], [], [], [], [1399, 648], [1399, 648], [1399, 648], [1399, 648], [], [], []]
