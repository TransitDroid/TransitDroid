var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":34,"id":1174,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19},{"el":27,"sc":2,"sl":24},{"el":32,"sc":2,"sl":29}],"name":"UnitOfWorkTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_107":{"methods":[{"sl":14}],"name":"testCommit","pass":true,"statements":[]},"test_147":{"methods":[{"sl":9}],"name":"testGetInstance","pass":true,"statements":[]},"test_182":{"methods":[{"sl":24}],"name":"testRegisterNew","pass":false,"statements":[{"sl":26}]},"test_43":{"methods":[{"sl":19}],"name":"testRegisterDirty","pass":true,"statements":[]},"test_82":{"methods":[{"sl":29}],"name":"testRegisterRemoved","pass":false,"statements":[{"sl":31}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [147], [], [], [], [], [107], [], [], [], [], [43], [], [], [], [], [182], [], [182], [], [], [82], [], [82], [], [], []]
