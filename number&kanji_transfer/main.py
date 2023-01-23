from typing import Optional
from fastapi import FastAPI, status, Response
from fastapi.responses import HTMLResponse
import urllib.parse

app = FastAPI()

@app.get("/", response_class=HTMLResponse)
async def read_root():
    return """
        <html>
            <head>
                <title>Home</title>
            </head>
            <body>
                <h1>Welcome to Kohtaroh's document for coding test!</h1>
                Add "/vi" to the URL above to start.
            </body>
        </html>
        """

@app.get("/vi", response_class=HTMLResponse)
async def read_root():
   return """
        <html>
            <head>
                <title>Home</title>
            </head>
            <body>
                <p>Add /number2kanji to the URL above to transfer Number to Kanji.</p>
                <p>Add /kanji2number to the URL above to transfer Kanji to Nunber.</p>
            </body>
        </html>
        """ 

@app.get("/vi/number2kanji/{input_number}", status_code=status.HTTP_200_OK)
async def n2k(input_number:int, response: Response):
    if not (0 <= int(input_number) <= 9999999999999999):
        response.status_code = status.HTTP_204_NO_CONTENT
        return {'error': f'Input number {str(input_number)} is not appropriate'}
    n2k_dict = {
        0: ' ',
        1: '壱', 
        2: '弍', 
        3: '参', 
        4: '四', 
        5: '五', 
        6: '六', 
        7: '七', 
        8: '八', 
        9: '九' 
        }
    digit_list = {
        1: '',
        10: '拾',
        100: '百',
        1000: '千',
        10000: '万',
        100000000: '億',
        1000000000000: '兆'
    }
    input_number_list = list(str(input_number))
    input_number_list.reverse()
    digit_num = len(input_number_list)
    splited_input_number_list = []
    for i in range(0, digit_num, 4):list
        splited_input_number_list.append(input_number_list[i:i+4])
    res_kanji = [0]*len(splited_input_number_list)
    for j in range(len(splited_input_number_list)):
        res_kanji[j] = []
        for d, k in enumerate(list(map(int, splited_input_number_list[j]))):
            if k == 0:
                continue
            res_kanji[j].append(digit_list[10**d])
            res_kanji[j].append(n2k_dict[k])
        res_kanji[j].reverse()
    for e, l in enumerate(res_kanji):
        l.append(digit_list[(10**4)**e])
        res_kanji[e] = ''.join(l)
    res_kanji.reverse()
    kanji = ''.join(res_kanji)
    return kanji

@app.get("/vi/kanji2number/{input_kanji}", status_code=status.HTTP_200_OK)
async def k2n(input_kanji: str, response: Response):
    k2n_dict = {
        ' ': 0,
        '壱': 1, 
        '弍': 2, 
        '参': 3, 
        '四': 4, 
        '五': 5, 
        '六': 6, 
        '七': 7, 
        '八': 8, 
        '九': 9 
        }
    digit_list = {
        ' ': 1,
        '拾': 10,
        '百': 100,
        '千': 1000,
        '万': 10000,
        '億': 100000000,
        '兆': 1000000000000
    }
    input_kanji_list = list(input_kanji)
    for letter in input_kanji_list:
        if not ((letter in k2n_dict.keys()) or (letter in digit_list.keys())):
            response.status_code = status.HTTP_204_NO_CONTENT
            return {'error': f'Input kanji {input_kanji} is not appropriate'}
    input_kanji_list.append(' ')
    input_kanji_list.reverse()
    key_kanji_list = [' ', '万', '億', '兆']
    digit_index_flag = []
    for i in key_kanji_list:
        digit_index_flag.append(i in input_kanji_list)
    digit_index_list = []
    for j, d in enumerate(digit_index_flag):
        if d:
            digit_index_list.append(input_kanji_list.index(key_kanji_list[j]))
    splited_kanji_list = []
    for k in range(len(digit_index_list)):
        if k == len(digit_index_list)-1:
            splited_kanji_list.append(input_kanji_list[digit_index_list[k]:(len(input_kanji_list))])
        else:
            splited_kanji_list.append(input_kanji_list[digit_index_list[k]:digit_index_list[k+1]])
    key_kanji_list2 = ['拾', '百', '千']
    total = 0
    for l in splited_kanji_list:
        base_number = digit_list[l[0]]
        subtotal = 0
        for m, e in enumerate(l):
            if m == 0 and not l[1] in key_kanji_list2:
                subtotal += k2n_dict[l[1]]
            if e in key_kanji_list2:
                subtotal += digit_list[e]*k2n_dict[l[m+1]]
        total += base_number*subtotal
    return total
        