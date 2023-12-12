#!/bin/bash

## Content



## How to run

#1. Install the dependencies

#```bash
pip install fastapi
pip install openai
pip install pydantic
pip install uvicorn
#```

#2. Start the FastAPI server

#```bash
python3 ChatBot.py
#```
#4. Start FastAPI server 

uvicorn ChatBot:app --reload

#4. Start the React app in other CMD 

#```bash
#cd app
#npm install
#npm start
#```