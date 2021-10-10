from flask import Flask, render_template, request, session
from compiler import compiler_gui
from symbol_table import print_code

app = Flask(__name__, template_folder='./Interfaz/Template', static_folder='./Interfaz/Static')
app.secret_key = 'vamos'

@app.route('/')
def code():
    code = ''
    if session.get('code'):
        code = session['code']
    return render_template('code.html', code=code)    

@app.route('/', methods=['POST'])
def get_code():
    code = request.form['src']
    session['code'] = code
    visited_decaf, ic = compiler_gui(code)
    session['errors'] = visited_decaf.error
    # print(session['errors'])
    session['intermediate_code'] = ic
    return render_template('code.html', code=code)

@app.route('/tree')
def tree():
    return render_template('tree.html')

@app.route('/errors')
def errors():
    e = session.get('errors')
    return render_template('errors.html', errors=e)

@app.route('/intermediate_code')
def intermediate_code():
    e = session.get('intermediate_code')
    return render_template('intermediate_code.html', intermediate_code=e)

if __name__ == '__main__':
    app.run(host='localhost', port=5000, debug=True)