var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":34,"id":2564,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19},{"el":27,"sc":2,"sl":24},{"el":32,"sc":2,"sl":29}],"name":"LoginRequestTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1085":{"methods":[{"sl":9}],"name":"testLoginRequest","pass":false,"statements":[{"sl":11}]},"test_1102":{"methods":[{"sl":29}],"name":"testSetPassword","pass":false,"statements":[{"sl":31}]},"test_1185":{"methods":[{"sl":14}],"name":"testGetUsername","pass":false,"statements":[{"sl":16}]},"test_1241":{"methods":[{"sl":24}],"name":"testGetPassword","pass":false,"statements":[{"sl":26}]},"test_1533":{"methods":[{"sl":24}],"name":"testGetPassword","pass":false,"statements":[{"sl":26}]},"test_199":{"methods":[{"sl":29}],"name":"testSetPassword","pass":false,"statements":[{"sl":31}]},"test_307":{"methods":[{"sl":14}],"name":"testGetUsername","pass":false,"statements":[{"sl":16}]},"test_31":{"methods":[{"sl":19}],"name":"testSetUsername","pass":false,"statements":[{"sl":21}]},"test_698":{"methods":[{"sl":19}],"name":"testSetUsername","pass":false,"statements":[{"sl":21}]},"test_810":{"methods":[{"sl":9}],"name":"testLoginRequest","pass":false,"statements":[{"sl":11}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [1085, 810], [], [1085, 810], [], [], [1185, 307], [], [1185, 307], [], [], [698, 31], [], [698, 31], [], [], [1241, 1533], [], [1241, 1533], [], [], [199, 1102], [], [199, 1102], [], [], []]
