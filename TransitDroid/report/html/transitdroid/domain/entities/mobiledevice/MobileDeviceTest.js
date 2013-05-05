var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":29,"id":3608,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19},{"el":27,"sc":2,"sl":24}],"name":"MobileDeviceTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1003":{"methods":[{"sl":14}],"name":"testMobileDevice","pass":false,"statements":[{"sl":16}]},"test_1142":{"methods":[{"sl":19}],"name":"testSetMobileDeviceMAC","pass":false,"statements":[{"sl":21}]},"test_1341":{"methods":[{"sl":24}],"name":"testGetMobileDeviceMAC","pass":false,"statements":[{"sl":26}]},"test_1470":{"methods":[{"sl":19}],"name":"testSetMobileDeviceMAC","pass":false,"statements":[{"sl":21}]},"test_1577":{"methods":[{"sl":9}],"name":"testMobileDeviceUUIDIntString","pass":false,"statements":[{"sl":11}]},"test_318":{"methods":[{"sl":14}],"name":"testMobileDevice","pass":false,"statements":[{"sl":16}]},"test_527":{"methods":[{"sl":24}],"name":"testGetMobileDeviceMAC","pass":false,"statements":[{"sl":26}]},"test_667":{"methods":[{"sl":9}],"name":"testMobileDeviceUUIDIntString","pass":false,"statements":[{"sl":11}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [667, 1577], [], [667, 1577], [], [], [1003, 318], [], [1003, 318], [], [], [1470, 1142], [], [1470, 1142], [], [], [527, 1341], [], [527, 1341], [], [], []]
