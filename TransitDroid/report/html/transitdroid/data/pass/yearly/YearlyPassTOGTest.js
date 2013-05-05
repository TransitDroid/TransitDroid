var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":34,"id":1066,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19},{"el":27,"sc":2,"sl":24},{"el":32,"sc":2,"sl":29}],"name":"YearlyPassTOGTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_108":{"methods":[{"sl":29}],"name":"testDelete","pass":false,"statements":[{"sl":31}]},"test_163":{"methods":[{"sl":14}],"name":"testFindAll","pass":false,"statements":[{"sl":16}]},"test_183":{"methods":[{"sl":19}],"name":"testFind","pass":false,"statements":[{"sl":21}]},"test_24":{"methods":[{"sl":24}],"name":"testUpdate","pass":false,"statements":[{"sl":26}]},"test_83":{"methods":[{"sl":9}],"name":"testInsert","pass":false,"statements":[{"sl":11}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [83], [], [83], [], [], [163], [], [163], [], [], [183], [], [183], [], [], [24], [], [24], [], [], [108], [], [108], [], [], []]
