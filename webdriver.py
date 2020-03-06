import unittest
from selenium import webdriver

class Search(unittest.TestCase):

    def setUp(self):
        self.driver = webdriver.Chrome()

    def test_search(self):
        driver = self.driver
        driver.get("http://www.google.com")
        search = driver.find_element_by_name("q")
        search.send_keys("blastim")
        search.submit()
        first_link = driver.find_element_by_class_name("r")
        expected = "Бластим: работа в биотехнологиях\nblastim.ru"
        actual = first_link.text
        self.assertEqual(expected, actual)
        #print(first_link.text) 
        
    def tearDown(self):
        self.driver.close()

if __name__ == "__main__":
    unittest.main()
