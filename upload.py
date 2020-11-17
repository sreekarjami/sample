#! /usr/bin/python
import boto3
import os
import sys
import yaml
import hashlib
import requests


print("Build number : " + str(sys.argv[1]))

