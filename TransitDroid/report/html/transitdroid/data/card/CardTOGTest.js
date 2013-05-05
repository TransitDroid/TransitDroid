var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":101,"id":928,"methods":[{"el":79,"sc":2,"sl":34},{"el":84,"sc":2,"sl":81},{"el":89,"sc":2,"sl":86},{"el":94,"sc":2,"sl":91},{"el":99,"sc":2,"sl":96}],"name":"CardTOGTest","sl":30}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":34}],"name":"testInsert","pass":false,"statements":[{"sl":37},{"sl":38},{"sl":39}]},"test_149":{"methods":[{"sl":91}],"name":"testUpdate","pass":true,"statements":[]},"test_152":{"methods":[{"sl":96}],"name":"testDelete","pass":true,"statements":[]},"test_26":{"methods":[{"sl":81}],"name":"testFindAll","pass":true,"statements":[]},"test_58":{"methods":[{"sl":86}],"name":"testFind","pass":true,"statements":[]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [10], [], [], [10], [10], [10], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [26], [], [], [], [], [58], [], [], [], [], [149], [], [], [], [], [152], [], [], [], [], []]
