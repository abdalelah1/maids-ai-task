def validate_input(data, features):
    """
    Validate the input data to ensure all required features are present and correct.
    """
    for feature in features:
        if feature not in data:
            return False, f"Missing feature: {feature}"
        if not isinstance(data[feature], (int, float)) or data[feature] < 0:
            return False, f"Invalid value for {feature}: {data[feature]}"
    
    return True, None
