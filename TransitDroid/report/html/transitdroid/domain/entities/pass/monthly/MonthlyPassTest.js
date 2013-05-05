var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":69,"id":3481,"methods":[{"el":12,"sc":2,"sl":9},{"el":17,"sc":2,"sl":14},{"el":22,"sc":2,"sl":19},{"el":27,"sc":2,"sl":24},{"el":32,"sc":2,"sl":29},{"el":37,"sc":2,"sl":34},{"el":42,"sc":2,"sl":39},{"el":47,"sc":2,"sl":44},{"el":52,"sc":2,"sl":49},{"el":57,"sc":2,"sl":54},{"el":62,"sc":2,"sl":59},{"el":67,"sc":2,"sl":64}],"name":"MonthlyPassTest","sl":7}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1125":{"methods":[{"sl":24}],"name":"testMonthlyPassLongInt","pass":false,"statements":[{"sl":26}]},"test_128":{"methods":[{"sl":54}],"name":"testSetMonth","pass":false,"statements":[{"sl":56}]},"test_131":{"methods":[{"sl":64}],"name":"testSetYear","pass":false,"statements":[{"sl":66}]},"test_1344":{"methods":[{"sl":24}],"name":"testMonthlyPassLongInt","pass":false,"statements":[{"sl":26}]},"test_1481":{"methods":[{"sl":29}],"name":"testGetVersion","pass":false,"statements":[{"sl":31}]},"test_171":{"methods":[{"sl":59}],"name":"testGetYear","pass":false,"statements":[{"sl":61}]},"test_239":{"methods":[{"sl":39}],"name":"testGetId","pass":false,"statements":[{"sl":41}]},"test_254":{"methods":[{"sl":9}],"name":"testMonthlyPassLongIntCalendar","pass":false,"statements":[{"sl":11}]},"test_260":{"methods":[{"sl":9}],"name":"testMonthlyPassLongIntCalendar","pass":false,"statements":[{"sl":11}]},"test_284":{"methods":[{"sl":34}],"name":"testSetVersion","pass":false,"statements":[{"sl":36}]},"test_304":{"methods":[{"sl":49}],"name":"testGetMonth","pass":false,"statements":[{"sl":51}]},"test_346":{"methods":[{"sl":44}],"name":"testSetId","pass":false,"statements":[{"sl":46}]},"test_353":{"methods":[{"sl":64}],"name":"testSetYear","pass":false,"statements":[{"sl":66}]},"test_383":{"methods":[{"sl":14}],"name":"testMonthlyPassLongIntIntInt","pass":false,"statements":[{"sl":16}]},"test_503":{"methods":[{"sl":19}],"name":"testMonthlyPass","pass":false,"statements":[{"sl":21}]},"test_575":{"methods":[{"sl":49}],"name":"testGetMonth","pass":false,"statements":[{"sl":51}]},"test_597":{"methods":[{"sl":39}],"name":"testGetId","pass":false,"statements":[{"sl":41}]},"test_7":{"methods":[{"sl":59}],"name":"testGetYear","pass":false,"statements":[{"sl":61}]},"test_740":{"methods":[{"sl":14}],"name":"testMonthlyPassLongIntIntInt","pass":false,"statements":[{"sl":16}]},"test_830":{"methods":[{"sl":44}],"name":"testSetId","pass":false,"statements":[{"sl":46}]},"test_853":{"methods":[{"sl":54}],"name":"testSetMonth","pass":false,"statements":[{"sl":56}]},"test_936":{"methods":[{"sl":29}],"name":"testGetVersion","pass":false,"statements":[{"sl":31}]},"test_952":{"methods":[{"sl":19}],"name":"testMonthlyPass","pass":false,"statements":[{"sl":21}]},"test_995":{"methods":[{"sl":34}],"name":"testSetVersion","pass":false,"statements":[{"sl":36}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [260, 254], [], [260, 254], [], [], [383, 740], [], [383, 740], [], [], [503, 952], [], [503, 952], [], [], [1125, 1344], [], [1125, 1344], [], [], [936, 1481], [], [936, 1481], [], [], [284, 995], [], [284, 995], [], [], [597, 239], [], [597, 239], [], [], [346, 830], [], [346, 830], [], [], [304, 575], [], [304, 575], [], [], [853, 128], [], [853, 128], [], [], [7, 171], [], [7, 171], [], [], [131, 353], [], [131, 353], [], [], []]
