import base64
import cv2
import cvlib as cv
import numpy as np
import requests
from PIL import Image
import io

im = None
url = "https://forcommonground.files.wordpress.com/2018/01/apples-bananas.jpg?w=640"


def objectRecognition():
    img_resp = requests.get(url)
    imgnp = np.array(bytearray(img_resp.content), dtype=np.uint8)
    im = cv2.imdecode(imgnp, -1)

    label = cv.detect_common_objects(im)

    labelString = ', '.join(label[1])
    return labelString


def helloWorld():
    return "Hello world!"


def main(data):

    decodedData = base64.b64decode(data)
    npData = np.fromstring(decodedData, np.uint8)
    img = cv2.imdecode(npData, cv2.IMREAD_UNCHANGED)

    foo, label, faa = cv.detect_common_objects(img)
    labelString = ','.join(label)

    return labelString


if __name__ == "__main__":
    main()
