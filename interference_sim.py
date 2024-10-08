import random
import time

# The constants
SIGNAL_THRESHOLD = -70  # Good signal strength (in dBm)
INTERFERENCE_THRESHOLD = -90  # Signal strength that indicates interference
SIMULATION_DURATION = 60  # How long to run the simulation (in seconds)
INTERFERENCE_PROBABILITY = 0.1  # Chance of interference happening

def simulate_signal_strength():
    """
    Simulates the signal strength of a wireless camera.
    Returns a random signal strength value.
    """
    return random.randint(-100, -30)  # Random signal from -100 dBm to -30 dBm

def detect_interference(signal_strength):
    """
    Checks if the signal strength shows interference.
    Returns True if there's interference, otherwise False.
    """
    return signal_strength < INTERFERENCE_THRESHOLD  # Return True if signal is below the interference threshold

def main():
    """
    Main function to run the simulation.
    """
    print("Starting interference simulation...")
    start_time = time.time()  # Record the start time

    while time.time() - start_time < SIMULATION_DURATION:
        # Simulate signal strength
        signal_strength = simulate_signal_strength()

        # Check for interference
        interference_detected = detect_interference(signal_strength)

        # Log the current signal strength and status
        if interference_detected:
            print(f"Interference detected! Signal strength: {signal_strength} dBm")
        else:
            print(f"Normal operation. Signal strength: {signal_strength} dBm")

        # Randomly simulate interference
        if random.random() < INTERFERENCE_PROBABILITY:
            print("Simulating external interference...")
            signal_strength = INTERFERENCE_THRESHOLD - random.randint(1, 10)  # Simulate a drop in signal strength

        time.sleep(1)  # Wait for 1 second before the next reading

    print("Simulation ended.")

if __name__ == "__main__":
    main()
