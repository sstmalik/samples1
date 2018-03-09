from pyspark import SparkConf, SparkContext

conf = SparkConf().setMaster("local").setAppName("wordcount")
sc = SparkContext(conf = conf)

def parseLine(line):
    fields = line.split(',')
    stationID = fields[0]
    entryType = fields[2]
    temperature = float(fields[3]) * 0.1 * (9.0 / 5.0) + 32.0
    return (stationID, entryType, temperature)

lines = sc.textFile("file:///SparkCourse/COPYRIGHT")
words = lines.flatMap(lambda x:x.split())
wordcntrdd= words.map(lambda x:(x,1)).reduceByKey(lambda x,y: (x+y))
wordcnt = wordcntrdd.collect()

for result in wordcnt:
    print(result[0].encode('ascii','ignore'),result[1])