#!/bin/bash
# QMS Dashboard Launcher for macOS

PORT=8080
echo "Starting local QMS Dashboard on port $PORT..."

# Open the browser first (Wait for server to start in bg)
(sleep 1 && open "http://localhost:$PORT/qms-dashboard.html") &

# Start the server using python3
python3 -m http.server $PORT
