import requests
import random
import time
from datetime import datetime, timezone

URL = "http://localhost:9000/api/v1/ingestion"

# Add your JWT
JWT_TOKEN  = ""

HEADERS = {
    "Authorization": f"Bearer {JWT_TOKEN}",
    "Content-Type": "application/json"
}

device_ids = list(range(1, 101))  # Simulate 100 devices

while True:
    payload = {
        "deviceId": random.choice(device_ids),
        "energyConsumed": round(random.uniform(0.1, 10.0), 2),
        "timestamp": datetime.now(timezone.utc).isoformat().replace("+00:00", "Z")
    }

    response = requests.post(
        URL,
        json=payload,
        headers=HEADERS,
        timeout=5
    )

    if response.status_code == 201:
        print(f"✓ Sent: {payload}")
    else:
        print(f"✗ Error {response.status_code}: {response.text}")

    time.sleep(0.5)  # 2 requests/sec