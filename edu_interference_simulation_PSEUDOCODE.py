BEGIN Simulation

  // Define constants
  SET SIGNAL_THRESHOLD = -70    // Good signal strength in dBm
  SET INTERFERENCE_THRESHOLD = -90 // Signal strength indicating interference
  SET SIMULATION_DURATION = 60   // Duration of the simulation in seconds
  SET INTERFERENCE_PROBABILITY = 0.1 // Probability of interference occurrence

  FUNCTION simulate_signal_strength:
    RETURN RANDOM_VALUE(-100, -30) // Simulate signal strength between -100 dBm and -30 dBm

  FUNCTION detect_interference(signal_strength):
    IF signal_strength < INTERFERENCE_THRESHOLD THEN
      RETURN TRUE // Interference detected
    ELSE
      RETURN FALSE // No interference

  FUNCTION main:
    PRINT "Starting interference simulation..."
    SET start_time = CURRENT_TIME()

    WHILE CURRENT_TIME() - start_time < SIMULATION_DURATION:
      // Simulate signal strength
      SET signal_strength = simulate_signal_strength()

      // Check for interference
      SET interference_detected = detect_interference(signal_strength)

      // Log the current signal strength and interference status
      IF interference_detected THEN
        PRINT "Interference detected! Signal strength: " + signal_strength + " dBm"
      ELSE
        PRINT "Normal operation. Signal strength: " + signal_strength + " dBm"

      // Randomly simulate interference occurrence
      IF RANDOM_VALUE(0, 1) < INTERFERENCE_PROBABILITY THEN
        PRINT "Simulating external interference..."
        SET signal_strength = INTERFERENCE_THRESHOLD - RANDOM_VALUE(1, 10) // Decrease signal strength

      // Wait for a short interval before the next measurement
      WAIT(1 second)

    PRINT "Simulation ended."

END Simulation
