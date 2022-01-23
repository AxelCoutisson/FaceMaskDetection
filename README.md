# FaceMaskDetection

## Informations
Ce repositorie est dédié à une utilisation de yoloV5 pour de la détection de masque chirurgical. Trois classes définissent l'état dans lequel le masque est porté: 

1. mask_weared_incorrect
2. with_mask
3. without_mask

Voici le repo utilisé de YoloV5 d'Ultralytics:
git clone https://github.com/ultralytics/yolov5


## Install
### Linux
Installation pour Linux
```console
mkdir yolo
cd yolo
mkdir venv
python3 -m venv ./venv
source venv/bin/activate
git clone https://github.com/AxelCoutisson/FaceMaskDetection.git
cd FaceMaskDetection
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
Voici des exemples pour la detection par camera:
Détection classique:
```console
python detect.py --source 0 --weights best_medium_mask.pt
```
Pour spécifiquement utiliser le CPU vous pouvez utiliser la commande suivante:
```console
python detect.py --source 0 --device cpu --weights best_medium_mask.pt
```

La détection étant gourmande en ressouces, il existe deux autres version des poids pour une éxécution plus rapide:

```console
python detect.py --source 0 --device cpu --weights best_slim_mask.pt
``` 
```console
python detect.py --source 0 --device cpu --weights best_nano_mask.pt
```
Si la détection n'est toujours pas fluide sur votre ordinateur vous pouvez encore déscendre en précision pour gagner en performance:
```console
python detect.py --source 0 --device cpu --weights best_slim_mask.pt --half --img-size 288
``` 
```console
python detect.py --source 0 --device cpu --weights best_nano_mask.pt --half --img-size 288
```

## Evaluation
Pour l'évaluation du dataset, nous en utiliserons un de kaggle: https://www.kaggle.com/andrewmvd/face-mask-detection celui-ci est déjà configuré et disponible sur ce repository. Nous utilisons aussi pycocotools, son installation est disponible dans le code ci-dessous.
Ces évaluations sont dépendantes des capacité de l'ordinateur c'est pourquoi nous vous mettons les commandes de test à disposition pour reproduire nos résultat sur votre machine:

```console
pip install pycocotools
``` 
Ensuite, il est possible de tester son entrainement sur ce dataset kaggle avec la commande ci-dessous. Notez qu'il faut modifier le fichier de poids que l'on veut tester:
```console
python val.py --weights best_slim_mask.pt --data ./data/coco.yaml --device cpu --img 640 --iou 0.65 --verbose
``` 