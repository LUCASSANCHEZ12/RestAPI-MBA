#!/bin/bash

## Content



## How to run

#1. Install the dependencies

#```bash
pip3 install fastapi
pip3 install openai
pip3 install pydantic
pip3 install uvicorn
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