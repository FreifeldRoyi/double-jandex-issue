IndexView was injected in MyOASFilter and as it seems MyOASAnnotation is being indexed twice.  
You can try with different annotations as well (such as GET) and you'll get the same result.  
Note that I use jandex plugin since this is originally a library and I didn't create an extension like I should. But even in this case, when I remove jandex plugin, it still indexes twice.