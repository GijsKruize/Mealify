import base64
import cv2
import cvlib as cv
import numpy as np
import requests
from PIL import Image
import io

im = None
url = "http://192.168.78.213/capture"


def objectRecognition():
    img_resp = requests.get(url)
    imgnp = bytearray(img_resp.content)
    im = cv2.imdecode(np.array(imgnp), -1)

    bbox, label, conf = cv.detect_common_objects(im)

    return label


if __name__ == "__main__":
    print(objectRecognition())
