from pyspark import SparkConf,SparkContext


conf = SparkConf().setMaster("local").setAppName("sample1")
sc = SparkContext(conf = conf)

rdd = sc.parallelize([1,2,3],5);
rdd2 = sc.parallelize([3,4],6);
output = rdd.coalesce(2).collect()
print(output)