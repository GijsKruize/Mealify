import cv2
import cvlib as cv
import urllib.request
import numpy as np
import requests

im = None
url = "https://i.imgur.com/85wyR2x.jpg?fb"


def objectRecognition():
    img_resp = requests.get(url).content
    imgnp = np.asarray(bytearray(img_resp), dtype=np.uint8)
    im = cv2.imdecode(imgnp, -1)

    label = cv.detect_common_objects(im)

    labelString = ''.join(label[1])
    return labelString


def helloWorld():
    return "Hello world!"


def main():
    print(objectRecognition())


if __name__ == "__main__":
    main()
