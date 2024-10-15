import unittest
import json
from app import app

class FlaskTestCase(unittest.TestCase):
    def setUp(self):
        self.app = app.test_client()
        self.app.testing = True

    def test_predict_success(self):
        payload = {
            "ram": 1024,
            "px_width": 1200,
            "px_height": 800,
            "battery_power": 3000
        }
        response = self.app.post('/predict', json=payload)
        data = json.loads(response.data)
        self.assertEqual(response.status_code, 200)
        self.assertIn("price_range", data)

    def test_predict_missing_feature(self):
        payload = {
            "ram": 1024,
            "px_width": 1200
        }
        response = self.app.post('/predict', json=payload)
        data = json.loads(response.data)
        self.assertEqual(response.status_code, 400)
        self.assertIn("error", data)

if __name__ == '__main__':
    unittest.main()
