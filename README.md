# FaceMaskDetection

## Informations
Here is the yoloV5 version of our mask detection. The notable difference with yolov4 is on the speed of treatment with much more images per second.

## Install
### Linux
Installation pour Linux
```console
mkdir yolo
cd yolo
mkdir venv
python3 -m venv ./venv
source venv/bin/activate
git clone https://github.com/ultralytics/yolov5
cd yolov5
pip install -r requirements.txt
```

### Windows
Installation pour Windows
```console
mkdir venv
python -m venv ./venv
.\venv\Scripts\activate
git clone https://github.com/AxelCoutisson/FaceMaskDetection.git
cd FaceMaskDetection
pip install -r requirements.txt
``` 
## Detection
Voici des exemples pour la detection par camera en utilisant le CPU
```console
python detect.py --source 0 --device cpu --weights best_slim_mask.pt --half --img-size 288
``` 
Alternative plus rapide sur camera et utilisation cpu
```console
python detect2.py
```

## Evaluation
Pour l'évaluation du dataset https://www.kaggle.com/andrewmvd/face-mask-detection déjà configurer et disponible sur ce repository. On utilise pycocotools qui sera a installer préhalablement.
```console
pip install pycocotools
``` 
Ensuite il est possible de tester son entrainement sur ce dataset kaggle avec la commande suivante :
```console
python val.py --weights best_slim_mask.pt --data ./data/coco.yaml --device cpu --img 640 --iou 0.65 --verbose
``` 