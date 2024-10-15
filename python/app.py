from flask import Flask, request, jsonify
import joblib
import numpy as np
from utils.preprocessing import validate_input  # Import custom validation function

# Initialize Flask app
app = Flask(__name__)

# Load the trained model
model = joblib.load('models/device_predict.pkl')

# Define the important features
important_features = ['ram', 'px_width', 'px_height', 'battery_power']

@app.route('/predict', methods=['POST'])
def predict():
    data = request.json
    valid, error_message = validate_input(data, important_features)
    
    if not valid:
        return jsonify({"error": error_message}), 400

    input_data = [data[feature] for feature in important_features]
    input_array = np.array(input_data).reshape(1, -1)

    # Make prediction
    try:
        prediction = model.predict(input_array)
    except Exception as e:
        return jsonify({"error": str(e)}), 500

    return jsonify({"price_range": int(prediction[0])})

if __name__ == '__main__':
    app.run(debug=True)
