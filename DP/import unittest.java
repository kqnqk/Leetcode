import unittest
from UglyNumberII import nthUglyNumber2

class TestUglyNumberII(unittest.TestCase):

    def test_nth_ugly_number(self):
        self.assertEqual(nthUglyNumber2(1), 1)
        self.assertEqual(nthUglyNumber2(2), 2)
        self.assertEqual(nthUglyNumber2(3), 3)
        self.assertEqual(nthUglyNumber2(4), 4)
        self.assertEqual(nthUglyNumber2(5), 5)
        self.assertEqual(nthUglyNumber2(6), 6)
        self.assertEqual(nthUglyNumber2(7), 8)
        self.assertEqual(nthUglyNumber2(8), 9)
        self.assertEqual(nthUglyNumber2(9), 10)
        self.assertEqual(nthUglyNumber2(10), 12)
        
        # Edge cases
        self.assertEqual(nthUglyNumber2(0), 0)
        self.assertEqual(nthUglyNumber2(-1), 0)
        
if __name__ == '__main__':
    unittest.main()
