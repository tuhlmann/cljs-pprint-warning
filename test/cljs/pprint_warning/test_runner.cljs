(ns pprint-warning.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [pprint-warning.core-test]
   [pprint-warning.common-test]))

(enable-console-print!)

(doo-tests 'pprint-warning.core-test
           'pprint-warning.common-test)
