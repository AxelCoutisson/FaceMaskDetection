from cx_Freeze import setup, Executable
  
executables = [
        Executable(script = "detect2.py",icon = "", base = "Win32GUI" )
]
# ne pas mettre "base = ..." si le programme n'est pas en mode graphique, comme c'est le cas pour chiffrement.py.
  
buildOptions = dict( 
        includes = ["argparse","os","sys","pathlib","cv2","torch","torch.backends.cudnn","models.common","utils.datasets","utils.general","utils.plots","utils.torch_utils"],
        include_files = []
)
  
setup(
    name = "yoloV5Detect",
    version = "0.0",
    description = "description du programme",
    author = "votre nom",
    options = dict(build_exe = buildOptions),
    executables = executables
)