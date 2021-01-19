var path = require('path')
var webpack = require('webpack')
const packageJSON = require('./package.json');
const urlJoin = require('url-join');
//const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;
//const CleanWebpackPlugin = require('clean-webpack-plugin');
const PATHS = {
  build: path.join(__dirname, 'target', 'classes', 'META-INF', 'resources', 'webjars', packageJSON.name, packageJSON.version),
  'public': urlJoin('webjars', packageJSON.name, packageJSON.version,"/")
};

module.exports = {
  entry: {'form-query': path.resolve(__dirname,'./src/js/formQuery.js')},
  output: {
    path: PATHS.build,
    filename: '[name].bundle.js',
    publicPath: PATHS['public']
  },
  module: {
    rules: [
      {
        test: /\.css$/,
        use: [
          'vue-style-loader',
          'css-loader'
        ],
      },      {
        test: /\.vue$/,
        loader: 'vue-loader',
        options: {
          loaders: {
          }
          // other vue-loader options go here
        }
      },
      {
        test: /\.js$/,
        loader: 'babel-loader',
        exclude: /node_modules/,
        query: {
          presets: ['es2015'],
          plugins: ["babel-plugin-transform-class-properties"]
        }
      },
      {
        test: /\.(png|jpg|gif|svg)$/,
        loader: 'file-loader',
        options: {
          name: '[name].[ext]?[hash]'
        }
      }
    ]
  },
  resolve: {
    alias: {
      'vue$': 'vue/dist/vue.esm.js'
    },
    extensions: ['*', '.js', '.vue', '.json']
  },
  devServer: {
    historyApiFallback: true,
    noInfo: true,
    overlay: true
  },
  performance: {
    hints: false
  },
  devtool: '#eval-source-map',
  /*plugins: [
    new CleanWebpackPlugin(['target','dist'], { verbose: true }),
    new webpack.ProvidePlugin({
      '$': 'jquery',
      jQuery: 'jquery',
      axios: 'axios',
      urlJoin: 'url-join',
      bootstrap: 'bootstrap'
    })
  ]*/
}

if (process.env.NODE_ENV === 'production') {
  module.exports.devtool = '#source-map'
  // http://vue-loader.vuejs.org/en/workflow/production.html
  module.exports.plugins = (module.exports.plugins || []).concat([
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: '"production"'
      }
    }),
    new webpack.optimize.UglifyJsPlugin({
      sourceMap: true,
      compress: {
        warnings: false
      }
    }),
    new webpack.LoaderOptionsPlugin({
      minimize: true
    })
  ])
}
